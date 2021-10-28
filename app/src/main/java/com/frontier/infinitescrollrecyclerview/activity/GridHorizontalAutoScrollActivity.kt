package com.frontier.infinitescrollrecyclerview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frontier.infinitescrollrecyclerview.R
import kotlinx.android.synthetic.main.activity_grid_horizontal_auto_scroll.*

class GridHorizontalAutoScrollActivity : AppCompatActivity() {

    private var integrationsArray = arrayListOf(
        R.drawable.integrations_1inch,
        R.drawable.integrations_aave,
        R.drawable.integrations_allianceblock,
        R.drawable.integrations_balancer,
        R.drawable.integrations_celo,
        R.drawable.integrations_compound,
        R.drawable.integrations_curve,
        R.drawable.integrations_dex,
        R.drawable.integrations_instadapp,
        R.drawable.integrations_kyb,
        R.drawable.integrations_luaswap,
        R.drawable.integrations_maker,
        R.drawable.integrations_matic,
        R.drawable.integrations_opensea,
        R.drawable.integrations_paraswap,
        R.drawable.integrations_rarible,
        R.drawable.integrations_sushi,
        R.drawable.integrations_synthetix,
        R.drawable.integrations_tokensets,
        R.drawable.integrations_unilend,
        R.drawable.integrations_uniswap,
        R.drawable.integrations_walletconnect,
        R.drawable.integrations_yearn,
//        R.drawable.integrations_zeroswap,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_horizontal_auto_scroll)
        recyclerView.startScrolling(integrationsArray)
    }
}