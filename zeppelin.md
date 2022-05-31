### Zeppelin
   - Interactive Data Analytics

#### Zeppelin Notebook
   - Choose Intrpreter as ilvy2
   - Once you add paragraph with the query / command, Click on '>' play icon or press'Shift + Enter'.
   - Results are displayed in output window, press 'Clear Output', to clear the results.

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
   - Problem : 500 Internal Server Error / session errors
     - Ambari -> Click on 'Zeppelin Notebook'
     - On the Actions button, select the option 'Restart All'