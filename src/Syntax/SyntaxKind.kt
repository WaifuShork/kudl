package Syntax

public fun String.lookupKeyword() : SyntaxKind {
    return when (this) {
        "fn" -> SyntaxKind.FuncKeyword
        "nil" -> SyntaxKind.NilKeyword
        "and" -> SyntaxKind.AndKeyword
        "class" -> SyntaxKind.ClassKeyword
        "else" -> SyntaxKind.ElseKeyword
        "false" -> SyntaxKind.FalseKeyword
        "for" -> SyntaxKind.ForKeyword
        "if" -> SyntaxKind.IfKeyword
        "or" -> SyntaxKind.OrKeyword
        "print" -> SyntaxKind.PrintKeyword
        "return" -> SyntaxKind.ReturnKeyword
        "super" -> SyntaxKind.SuperKeyword
        "this" -> SyntaxKind.ThisKeyword
        "true" -> SyntaxKind.TrueKeyword
        "var" -> SyntaxKind.VarKeyword
        "while" -> SyntaxKind.WhileKeyword
        else -> SyntaxKind.IdentifierToken
    }
}

public enum class SyntaxKind {
    BadToken,
    EndOfFileToken,

    OpenParenToken,
    CloseParenToken,
    OpenBraceToken,
    CloseBraceToken,
    CommaToken,
    DotToken,
    SemicolonToken,

    PlusToken,
    MinusToken,
    AsteriskToken,
    FSlashToken,

    IdentifierToken,
    StringLiteralToken,
    NumberLiteralToken,

    FuncKeyword,
    AndKeyword,
    ClassKeyword,
    ElseKeyword,
    FalseKeyword,
    ForKeyword,
    IfKeyword,
    OrKeyword,
    PrintKeyword,
    ReturnKeyword,
    SuperKeyword,
    ThisKeyword,
    TrueKeyword,
    VarKeyword,
    WhileKeyword,
    NilKeyword
}