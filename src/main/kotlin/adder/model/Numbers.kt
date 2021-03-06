package adder.model

data class Numbers(val nums: List<Number>) {
    constructor(input :Collection<String>): this(input.map(::Number))
}
