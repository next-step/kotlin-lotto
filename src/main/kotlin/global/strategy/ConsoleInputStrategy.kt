package global.strategy

object ConsoleInputStrategy : InputStrategy {
    override fun input(): String = readLine() ?: throw IllegalArgumentException("문자열을 입력해주세요")
}
