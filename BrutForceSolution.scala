

object BrutForceSolution{
  def brutForceSolution(s:String):Int={
    var res=0

    val tb="%"+s+"&"
    for(i<-1 until tb.length-1)
    {
      for(par<-0 to 1)
      {
        var j=0
        while(tb(i+j+1-par)==tb(i-(j+1)))
          j+=1
        res+=j
      }
    }
    if(res<=1e8)
      return res
    return -1
  }

}
