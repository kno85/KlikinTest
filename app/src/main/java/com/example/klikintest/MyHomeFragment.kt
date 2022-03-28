import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klikintest.CustomAdapter
import com.example.klikintest.R
import com.example.klikintest.getMockedPlaceList
import com.example.klikintest.viewActions

val ITEM_ID: String="item_id"

class HomeFragment : Fragment(), viewActions {
    private lateinit var mview: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mview = inflater.inflate(R.layout.fragment_main, container, false)
        setupView()
        return mview
    }

    private fun setupView() {
        val rV = mview.findViewById<RecyclerView>(R.id.rv)
        rV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rV.adapter= CustomAdapter(getMockedPlaceList(), this)
    }

    override fun onItemClick(itemId: Int) {
        val bundle = bundleOf(ITEM_ID to itemId.toString())

        Navigation.findNavController(mview).navigate(R.id.action_myHomeFragment_to_detailFragment
            , bundle)
    }


}


