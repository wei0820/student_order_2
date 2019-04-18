import android.content.Context
import android.content.Context.MODE_PRIVATE

object MySharedPrefernce{
    // 儲存搜尋紀錄

    fun setList(context: Context, list :ArrayList<String>){
        val editor = context.getSharedPreferences("EnvironDataList", MODE_PRIVATE).edit()
        editor.putInt("EnvironNums", list.size)
        for (i in list.indices) {
            editor.putString("item_$i", list[i])
        }
        editor.commit()
    }
    // 取得搜尋紀錄

    fun  getList(context: Context):ArrayList<String>{
        val environmentList = ArrayList<String>()
        val preferDataList = context.getSharedPreferences("EnvironDataList", MODE_PRIVATE)
        val environNums = preferDataList.getInt("EnvironNums", 0)
        for (i in 0 until environNums) {
            val environItem = preferDataList.getString("item_$i", null)
            environmentList.add(environItem)
        }
        return  environmentList
    }
    // 儲存搜尋紀錄

    fun setPriceList(context: Context, list :ArrayList<String>){
        val editor = context.getSharedPreferences("pricelist", MODE_PRIVATE).edit()
        editor.putInt("pricelistNums", list.size)
        for (i in list.indices) {
            editor.putString("item_$i", list[i])
        }
        editor.commit()
    }
    // 取得搜尋紀錄

    fun  getPriceList(context: Context):ArrayList<String>{
        val environmentList = ArrayList<String>()
        val preferDataList = context.getSharedPreferences("pricelist", MODE_PRIVATE)
        val environNums = preferDataList.getInt("pricelistNums", 0)
        for (i in 0 until environNums) {
            val environItem = preferDataList.getString("item_$i", null)
            environmentList.add(environItem)
        }
        return  environmentList
    }
}