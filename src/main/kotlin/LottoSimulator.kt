
fun main() {
    val tokens = LottoInputHandler.getNumbers()
    val sum = LottoProcessor.apply(tokens)

    LottoOutputHandler.display(sum)
}
