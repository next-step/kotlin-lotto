package lotto

fun generateLottoNumbers(): List<Int> {
    return (1..45).shuffled().take(6).sorted()
}
