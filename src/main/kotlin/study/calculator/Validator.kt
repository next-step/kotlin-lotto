package study.calculator

interface Validator<T> {
    fun validate(numbers: T)
}
