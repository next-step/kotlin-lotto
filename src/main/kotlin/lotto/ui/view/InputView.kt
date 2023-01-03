package lotto.ui.view

fun getPurchasePrice(): Int {
    println("구입금액을 입력해 주세요.")
    val amount = getInt()

    require(amount >= 1000) {
        print("1000원 이상을 입력해주세요. ")
        return getPurchasePrice()
    }

    return amount
}

fun getManualNumbers(): List<Set<Int>> {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    val repeatCount = getInt()

    println("수동으로 구매할 번호를 입력해 주세요.")
    return List(repeatCount) {
        getInts().toSet()
    }
}

fun getWinningLottoNumbers(): Set<Int> {
    println("지난 주 당첨 번호를 입력해 주세요.")

    return getInts().toSet()
}

fun getBonusLottoNumber(): Int {
    println("보너스 볼을 입력해 주세요.")

    return getInt()
}

private fun getInt(): Int {
    val number = readLine()?.toIntOrNull() ?: -1

    require(number != -1) {
        println("값을 입력해주세요")
        return getInt()
    }

    return number
}

private fun getInts(): List<Int> {
    val numbers = readLine()

    require(!numbers.isNullOrBlank()) {
        println("값을 입력해주세요.")
        return getInts()
    }

    return numbers
        .split(",")
        .map { it.trim().toInt() }
}
