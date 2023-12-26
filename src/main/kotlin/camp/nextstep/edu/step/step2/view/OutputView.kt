package camp.nextstep.edu.step.step2.view

import camp.nextstep.edu.step.step2.dto.LottoProcessDto
import camp.nextstep.edu.step.step2.dto.LottoResultDto

object OutputView {

    fun displayTicketsNumbers(lottoProcessDto: LottoProcessDto) {
        println("수동으로 ${lottoProcessDto.manualTicketAmount}장, 자동으로 ${lottoProcessDto.autoTicketAmount}개를 구매했습니다.")

        for (lottoTicket in lottoProcessDto.lottoTicketList) {
            println(lottoTicket)
        }

    }

    fun displayLottoResultByDto(lottoResultDto: LottoResultDto) {
        println("당첨 통계")
        println("---------")
        lottoResultDto.matchResponse.forEach { matchResponse ->
            println("${matchResponse.matchCount}개 일치 (${matchResponse.prize}원) - ${matchResponse.userMatchCont}개")
        }
        println("총 수익률은 %.2f 입니다.".format(lottoResultDto.lottoProfitRate))
    }

}
