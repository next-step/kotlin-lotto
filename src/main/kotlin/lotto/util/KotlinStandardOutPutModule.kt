package lotto.util

object KotlinStandardOutPutModule : OutPutModule {
    override fun write(outputValue: String) {
        println(outputValue)
    }
}
