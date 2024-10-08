class Solution {
    String ten[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String twenty[] = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String hund[]={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        if(num<10){
            return ten[num];
        }
        if(num<20){
            return twenty[num-10];
        }
        if(num<100){
            return hund[num/10]+ ((num%10 !=0)? " "+ten[num%10]:"");
        }
         if(num<1000){ //9 00
            return ten[num/100] + " Hundred" + (num%100!=0?" " + numberToWords(num%100):"");
        }
        if(num<1000000){ //9000 -- 999 000
            return numberToWords(num/1000) + " Thousand" + (num%1000!=0?" " + numberToWords(num%1000):"");
        }
        if(num<1000000000){ //999 129786
            return numberToWords(num/1000000) + " Million" + (num%1000000!=0?" " + numberToWords(num%1000000):"");
        }
        return numberToWords(num/1000000000) + " Billion" + (num%1000000000!=0?" " + numberToWords(num%1000000000):"");
    
    }
}
