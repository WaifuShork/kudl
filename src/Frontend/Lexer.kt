package Frontend

import Syntax.SyntaxKind
import Syntax.SyntaxToken
import Syntax.lookupKeyword

class Lexer(private val _source : String) {

    private val _tokens = ArrayList<SyntaxToken>()

    private var _startPos = 0
    private var _currentPos = 0
    private var _line = 1

    fun lexTokens() : ArrayList<SyntaxToken> {
        while (!isAtEnd()) {
            _startPos = _currentPos
            lexToken()
        }

        _tokens.add(SyntaxToken(SyntaxKind.EndOfFileToken, "", null, _line))
        return _tokens
    }

    private fun lexToken() {
        var char = advance()
        when (char) {
            '+' -> addToken(SyntaxKind.PlusToken)
            '-' -> addToken(SyntaxKind.MinusToken)
            '*' -> addToken(SyntaxKind.AsteriskToken)
            '/' -> addToken(SyntaxKind.FSlashToken)
            // Ignore whitespace
            ' ' -> { }
            '\r' -> { }
            '\t' -> { }
            '\n' -> _line++
            else -> {
                if (char.isLetter() || char == '_') {
                    lexIdentifierOrKeyword()
                } else if (char.isDigit()) {
                    lexNumericLiteral()
                } else if (char == '"' || char == '\'') {
                    lexStringOrCharLiteral()
                } else {
                    println("unexpected character")
                }
            }
        }
    }

    // ============ Partial Lexers ============ \\
    private fun lexIdentifierOrKeyword() {
        while (peekCurrent().isLetterOrDigit() || peekCurrent() == '_') {
            advance()
        }

        val text = _source.substring(_startPos, _currentPos)
        val kind = text.lookupKeyword()
        addToken(kind)
    }

    private fun lexNumericLiteral() {

    }

    private fun lexStringOrCharLiteral() {

    }

    // ============ Helpers ============ \\
    private fun isAtEnd() : Boolean {
        return _currentPos >= _source.length
    }

    private fun advance() : Char {
        return _source[_currentPos++]
    }

    private fun addToken(kind : SyntaxKind, value : Any? = null) {
        val text = _source.substring(_startPos, _currentPos)
        _tokens.add(SyntaxToken(kind, text, value, _line))
    }

    private fun match(expected : Char) : Boolean {
        if (isAtEnd()) {
            return false
        }
        if (_source[_currentPos] != expected) {
            return false
        }
        _currentPos++
        return true
    }

    private fun peekCurrent() : Char {
        if (isAtEnd()) {
            return '\u0000'
        }

        return _source[_currentPos]
    }
}