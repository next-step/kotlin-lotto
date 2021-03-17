# Step2
- [X] 구입금액 입력이 가능하다. -> InputView
    - [X] 로또의 가격은 1000원이다.
        - [X] 1000원 보다 적으면 Exception -> Input(amount: Int)
        - [X] 1000원 보다 많으면 / 1000의 갯수만큼 구매가 가능하다. -> Input.count -> amount / 1000
    
- [X] 여러개의 로또를 구매가 가능하다. -> LottoCollection
    - [X] 로또 개수만큼 만들 수 있다. -> LottoCollection(int, generator)
        - [X] 인자로는 로또 개수, 생성기를 주입이 가능하다.
    - [X] 로또 당첨 번호를 받아서, 등수를 return 할 수 있어야 한다 -> LottoCollection.matchByWonNumber() -> LottoRankCollection
        - [X] LottoRankCollection에는 6,5,4,3개 일치한 값의 갯수를 가지고 있어야 한다. -> Map<Rank, Integer> 
            - [X] Rank는 스스로 당첨금액을 알고 있어야 한다. ( enums ) 
                - [X] Rank는 당첨갯수를 기반으로 몇등인지 return이 가능해야한다 -> Rank.getRank(맞은갯수: int)
                - [ ] 기존에 1등을 제외한 나머지는 + 1등 씩 밀려야한다.
                - [ ] 5개의 숫자가 맞고 1개의 보너스 볼이 맞으면 2등이다.
                
            - [X] LottoRankCollection는 스스로 총합금액을 return할줄 알아야 한다 -> LottoRank.sum() -> Int
      
    - [X] 로또는 6개의 숫자를 갖고 있다 -> Lotto
        - [X] 생성시 LottoNumber을 같이 생성한다.
        - [X] 로또 넘버 생성기를 주입이 가능해야 한다 
        - [X] 로또의 숫자는 랜덤적으로 생성이 가능하다 -> LottoNumberRandomGenerator
        - [X] 로또 숫자는 1~45까지 갖고 있다 -> LottoNumber
        - [X] 로또의 숫자는 중첩이 불가능하다 -> Set
        - [X] 숫자를 맞춰 등수를 알아야 한다.
- [X] 출력 시 LottoCollection.getRanks() 를 통해 출력을 한다.
    - [X] LottoRankCollection.sum() / LottoCollection.lotto.size * 1000 을 수익률로 보여준다.
- [X] 당첨번호 LottoClass가 있어야 한다.
    - [X] 숫자는 6개만 받을 수 있다. Set<LottoNumber>
    - [X] 보너스 숫자를 하나 더 받을 수 있다.
    - [ ] 보너스 번호와 기존 번호는 겹쳐서는 안된다. 