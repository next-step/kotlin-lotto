
enum class ExceptionCode(
    private val message: String,
) {
    NOT_ALLOWED_MINUS("input에 음수가 있으면 안됩니다"),
    ;

    fun getMessage(): String {
        return this.message
    }
}
