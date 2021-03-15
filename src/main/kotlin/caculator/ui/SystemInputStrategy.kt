package caculator.ui

class SystemInputStrategy : InputStrategy {
    override fun enter(): String? {
        return readLine()
    }
}
