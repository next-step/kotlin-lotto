package lotto

data class Statistics(private val statistics: Map<Int, Int>) {

    constructor(vararg pairs: Pair<Int, Int>): this(mapOf(*pairs))
}
