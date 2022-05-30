package lotto.util

object KotlinStandardInputModule : InputModule {
    override fun read(): String {
        return readln()
    }
}
