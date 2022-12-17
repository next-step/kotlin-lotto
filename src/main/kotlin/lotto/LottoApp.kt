package lotto

import lotto.assemble.ObjectAssemble
import lotto.common.execute.Executable

class LottoApp(
    private val executableApp: Executable
) : Executable by executableApp

fun main() {
    val executableApp = ObjectAssemble.executableApp()
    val lottoApp = LottoApp(executableApp)
    lottoApp.execute()
}
