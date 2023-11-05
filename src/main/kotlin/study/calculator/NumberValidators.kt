package study.calculator

class NumberValidators(
    private val validatorList: List<Validator<List<Int>>>
) {
    fun validates(src: List<Int>) {
        validatorList.forEach {
            it.validate(src)
        }
    }
}
