package test;

public class calculator {
    int[] num = new int[3];
	int[] kor = new int[3];
	int[] eng = new int[3];
	int[] mat = new int[3];
	int[] sum= new int[3];
    double[] avg = new double[3];
    String[] name = new String[3];
    int[] r = {1,1,1};
	
    public void sum_func(){
        for(int i=0;i<3;i++)
                sum[i] = kor[i] + eng[i] + mat[i];
	}
    
    public void avg_func(){
        for(int i=0;i<3;i++)
                avg[i] = sum[i] / 3.0;
	}
	
    public void rank(){
		int i, k = 0;
        for(i=0;i<3;i++){
                for(k=0;k<3;k++){
                        if(sum[i] > sum[k])
                                r[k]++;
                }
        }
	}
    
    public void align(){
    	int tmp=0;
    	double tmpf=0.0f;
    	String tmps;
    	
		for(int i=0;i<3;i++)
		{
			for(int j=i;j<3;j++)
			{
				if(sum[i]<sum[j])
				{
					tmp=num[j];
					num[j]=num[i];
					num[i]=tmp;
					
					tmp=kor[j];
					kor[j]=kor[i];
					kor[i]=tmp;
					
					tmp=eng[j];
					eng[j]=eng[i];
					eng[i]=tmp;
					
					tmp=mat[j];
					mat[j]=mat[i];
					mat[i]=tmp;
					
					tmp=sum[j];
					sum[j]=sum[i];
					sum[i]=tmp;
					
					tmp=r[j];
					r[j]=r[i];
					r[i]=tmp;
					
					tmpf=avg[j];
					avg[j]=avg[i];
					avg[i]=tmpf;
					
					tmps=name[j];
					name[j]=name[i];
					name[i]=tmps;    					
				}
			}
		}
    }
}