package calculator

object Validator {

    @Throws(RuntimeException::class)
    fun validate(value: String) {
        val number = value.toIntOrNull() ?: throw RuntimeException("not number type !!")
        if (number < 0) throw RuntimeException("negative number !!")
    }
}
