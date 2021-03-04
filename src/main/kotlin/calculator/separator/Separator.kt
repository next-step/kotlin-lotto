package calculator.separator

enum class Separator(
    private val policy: SeparatorPolicy
) {
    CUSTOM(CustomSeparator()),
    DEFAULT(DefaultSeparator());

    private fun canSeparate(expression: String) = policy.canSeparate(expression)

    private fun separate(expression: String) = policy.separate(expression)

    companion object {
        fun separate(expression: String): List<String> {
            return values()
                .find { it.canSeparate(expression) }
                ?.separate(expression)
                ?: throw IllegalArgumentException("분해 할 수 없는 식($expression) 입니다.")
        }
    }
}
