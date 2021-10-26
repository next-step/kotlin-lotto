package global.strategy

object ConsoleOutputStrategy : OutputStrategy {
    override fun output(element: String) = println(element)
}
