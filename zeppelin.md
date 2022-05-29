### Zeppelin
   - Interactive Data Analytics

#### Zeppelin Notebook
   - Choose Intrpreter as ilvy2

###### Reading json   
   ```
      %ilvy2.spark
      var trades = spark.read.json("abfss://raw@snsystems.dfs.core.windows.net/trade/distribute/20220430/simulation/trades.json")
      trades.count
   ```

###### Reading parquet and creating SQL view
   ```
     %ilvy2.spark
     {
       val scope = spark.read.json("abfss://app@snsystems.dfs.core.windows.net/trade/output/20220430/simulation/part-*-ab12a12.gz.parquet")
       scope.createOrReplaceTempView("scope")

       val df1 = spark.sql("select count(distinct trade_id), asset from scope group by asset") 
     }
   ```


#### Issues
   - 500 Internal Server Error
     - Restart All