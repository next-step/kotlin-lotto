package global.strategy.ui

object ConsoleOutputStrategy : OutputStrategy {
    override fun output(element: String) = println(element)
}
