package view

object ManualPickInputView {
    fun receiveManualPick() {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readLine()!!.toInt()
    }
}
