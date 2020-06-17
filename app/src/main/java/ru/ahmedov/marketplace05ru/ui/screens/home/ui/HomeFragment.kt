package ru.ahmedov.marketplace05ru.ui.screens.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.ahmedov.marketplace05ru.App
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel
import ru.ahmedov.marketplace05ru.ui.global.BaseFragment
import ru.ahmedov.marketplace05ru.ui.screens.home.mvp.HomePresenter
import ru.ahmedov.marketplace05ru.ui.screens.home.mvp.HomeView
import javax.inject.Inject


class HomeFragment : BaseFragment(), HomeView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.homeComponentBuilder()
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        retainInstance = true;

findNavController().saveState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inItView()
    }

    override fun onBackPressed() {
    }

    fun inItView() {
        recyclerView_main.run {
            layoutManager = LinearLayoutManager(
                recyclerView_main.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            recyclerView_main.recycledViewPool.setMaxRecycledViews(10, 20);
        }
    }

    override fun showHome(home: List<HomeModel>) {
        val adapter =
            HomeAdapter(home)
        recyclerView_main.adapter = adapter
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showError(show: Boolean) {
    }

}