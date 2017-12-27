public class PublicGood {

    public double R;
    private double fund;
    public double w;

    public PublicGood(){}

    public PublicGood(double w, double R){
        this.R = R;
        this.w = w;
    }

    public double getRewardCooperator(int nbCooperators, int nbDefectors)
    {
        return R *(nbCooperators/(nbCooperators+nbDefectors)) - 1;
    }

    public double getRewardDefectors(int nbCooperators, int nbDefectors)
    {
        return R *(nbCooperators/(nbCooperators+nbDefectors));
    }

    public void invest()
    {
        fund += R * w;
    }


}
