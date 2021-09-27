import Extensions.cyan
import Frontend.Lexer
import kotlin.system.exitProcess

fun main(args : Array<String>) {
    val repl = Repl();
    while (true)
    {
        print("> ".cyan())
        val input = readLine() ?: break
        if (input.startsWith("#"))
        {
            repl.executeCommand(input)
            continue;
        }
        val lexer = Lexer(input)
        val tokens = lexer.lexTokens()
        for (token in tokens) {
            println(token.kind.name)
        }
    }
}

public class Repl
{
    public fun executeCommand(command : String)
    {
        when (command)
        {
            "#cls" -> println("clear screen")
            "#exit" -> exitProcess(0)
            else -> println("(invalid command)")
        }
    }
}

