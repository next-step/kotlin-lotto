
enum class ExceptionCode(
    private val message: String,
) {
    NOT_ALLOWED_NULL_OR_BLANK("input이 null이거나 빈 문자열일 수 없습니다"),
    NOT_ALLOWED_MINUS("input에 음수가 있으면 안됩니다"),
    ;

    fun getMessage(): String {
        return this.message
    }
}
