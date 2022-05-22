
fun main() {
    val tokens = LottoInputHandler.display()
    val sum = LottoProcessor.apply(tokens)

    LottoOutputHandler.display(sum)
}
