package study.calculator

interface Parser<IN, OUT> {
    fun parse(source: IN): OUT
}
