package simulator.io

class Input {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualCount():Int{
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualNumbers(manualCount:Int): List<String> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualCount){
            readln()
        }
    }

    fun getLastMatchNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }
}