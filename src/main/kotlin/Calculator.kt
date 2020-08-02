import model.Number

object Calculator {
    fun sum(list: List<Number>) = list.sumBy { it.number }
}
