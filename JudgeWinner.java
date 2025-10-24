public class JudgeWinner{
    private String playerRank;//1PK962 みたいなやつ
    private String cpuRank;
    private int playerHandPower;
    private int cpuHandPower;
    private String playerKicker;//K962 みたいなやつ
    private String cpuKicker;

    //playerの勝利 -> 1  引き分け -> 0 CPUの勝利 -> -1
    public int doJudge(Hand playerHand, Hand cpuHand){
        playerRank = playerHand.getRank();
        cpuRank = cpuHand.getRank();

        playerHandPower = quantifyRank(playerRank);
        cpuHandPower = quantifyRank(cpuRank);
        
        //引き分けになる可能性があるかどうか調べる
        if(playerHandPower == cpuHandPower){
            return compareSameRank();
        }else{
            //引き分けになりえない場合
            if(playerHandPower > cpuHandPower){
                return 1;
            }else{
                return -1;
            }
        }

        //return 999;

    }

    //quantify【他動】数値化する quantify (~を)
    public int quantifyRank(String rank){
        switch(rank.substring(0,2)){
            case "RF": return 9;
            case "SF": return 8;
            case "4K": return 7;
            case "FH": return 6;
            case "FL": return 5;
            case "ST": return 4;
            case "3K": return 3;
            case "2P": return 2;
            case "1P": return 1;
            case "HC": return 0;
        }
        return 999;
    }

    public int compareSameRank(){
        playerKicker = playerRank.substring(2);
        cpuKicker = cpuRank.substring(2);

        for(int i=0; i<playerKicker.length(); i++){
            if(rankToInt(String.valueOf(playerKicker.charAt(i))) > rankToInt(String.valueOf(cpuKicker.charAt(i)))){
                return 1;
            }else if(playerKicker.charAt(i) < cpuKicker.charAt(i)){
                return -1;
            }
        }

        return 0;
    }

    public int rankToInt(String rank){
        switch(rank){
            case "A": return 14;
            case "K": return 13;
            case "Q": return 12;
            case "J": return 11;
            case "T": return 10;
            case "9": return 9;
            case "8": return 8;
            case "7": return 7;
            case "6": return 6;
            case "5": return 5;
            case "4": return 4;
            case "3": return 3;
            case "2": return 2; 
        }
        return 999;
    }
}