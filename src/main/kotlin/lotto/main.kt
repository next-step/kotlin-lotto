package lotto

import lotto.service.LottoApplication
import lotto.util.KotlinRandomGenerate
import lotto.util.KotlinStandardInputModule
import lotto.util.KotlinStandardOutPutModule

fun main() {
    val lottoApplication = LottoApplication(KotlinStandardInputModule, KotlinStandardOutPutModule, KotlinRandomGenerate)
    lottoApplication.run()
}
