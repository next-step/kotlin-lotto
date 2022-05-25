package camp.nextstep.lotto.raffle

import camp.nextstep.lotto.ticket.LottoTicket

class TicketsByMatchCount(map: Map<Int, List<LottoTicket>>) : Map<Int, List<LottoTicket>> by map
