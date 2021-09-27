package Syntax

public data class SyntaxToken(val kind: SyntaxKind, val text: String, val value: Any?, val line: Int)