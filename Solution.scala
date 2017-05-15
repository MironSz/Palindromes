object Solution{
  def solution(s :String):Int={
      val tb="#"+s+"&*"
      val tablica:Array[Int]=new Array[Int](tb.length)
      var j=0
      for(i <- 1 until tb.length)
        tablica(i)=0
      def symetry(a:Int, b:Int):Int=b+b-a
      def min(a:Int, b:Int):Int= if(a<b) a else b
      def max(a:Int, b:Int):Int={-1*(min(-a,-b))}

      def manacherRec(ob:Int, r:Int, par:Int, prev:Int, res:Int):Int={

        var resLocal=res

        for(i<- prev until ob)
          if(i<tb.length) resLocal=resLocal+tablica(i)
        if(resLocal>1e8||resLocal<0)
          return -100000000

        if(ob+r+1-par>=tb.length)
          return resLocal
        if(tb(ob+r+1-par)==tb(ob-r-1))
          return manacherRec(ob,r+1,par,ob,resLocal);

        tablica(ob)=r
        j=ob-1
        if(r>1)
          while(j>=ob-r-1){
            tablica(symetry(j,ob))=min  (tablica(j),   j-(ob-r));
            if(j-tablica(j)-1<=ob-r)
              return manacherRec( symetry(j,ob),  tablica(symetry(j,ob)), par , ob , resLocal )
            j-=1
          }
          return manacherRec(ob+max(tablica(ob)-par,1),0,par,ob,resLocal)
        }
      var res=manacherRec(1,0,0,0,0);
      for(i<-1 until tb.length)
        tablica(i)=0;
      res=manacherRec(1,0,1,0,res)
      if(res<0) res=(-1)
      return res;
}
