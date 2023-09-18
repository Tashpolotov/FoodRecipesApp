package com.example.data

import android.content.Context
import android.util.Log
import com.example.domain.model.DetailsIngredientModel
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.InfoStepsModel
import com.example.domain.repository.FoodRepository



class FoodRepositoryMock(private val context: Context):FoodRepository {


    override fun getHome1(): List<HomeModel1> {
        return listOf(HomeModel1(
            "1",R.drawable.img_dessert, context.getString(R.string.dessert)),
            HomeModel1(
                "2",R.drawable.img_bakicn, context.getString(R.string.baking)),
            HomeModel1(
                "3",R.drawable.img_salads, context.getString(R.string.salads)),
            HomeModel1(
                "4",R.drawable.img_sneck, context.getString(R.string.snack)),


            )
    }

    override fun getHome2(): List<HomeModel2> {
        return listOf(
            HomeModel2("1", R.drawable.img_chocolate_cake, context.getString(R.string.chocolatecake), context.getString(
                            R.string.hard), "7", "4.5", "120 kcal", "60:01"),

            HomeModel2("1", R.drawable.img_cheesecake, context.getString(R.string.cheesecake), context.getString(
                            R.string.medium), "6", "4.7", "90 kcal", "45:10"),


            HomeModel2("2", R.drawable.img_classic_chocolate_cake, context.getString(R.string.classic_chocolate_cake), "Intermediate", "6",
                "4.7", "12 kcal", "90:15"),
            HomeModel2("2", R.drawable.img_homemad, context.getString(R.string.homemade_bread), context.getString(
                            R.string.easy), "9",
                "4.5", "1 kcal", "80:10"),


            HomeModel2("3", R.drawable.img_cucumber, context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.easy), "5", "4.3", "100 kcal", "14:00"),
            HomeModel2("3", R.drawable.img_ceaser, context.getString(R.string.caesar_salad), context.getString(R.string.easy), "6", "4.5", "120 kcal", "12:30"),



            HomeModel2("4", R.drawable.chips, context.getString(R.string.chips), context.getString(R.string.easy), "7",
                "4.3", "100 kcal", "14:00"),
        )

    }

    override fun getDetailsIngredient(): List<DetailsIngredientModel> {
        return listOf(
            DetailsIngredientModel(
            R.drawable.img_sugar, context.getString(R.string.chocolatecake), context.getString(R.string.sugar),"200 grams"),
            DetailsIngredientModel(
                R.drawable.img_flour, context.getString(R.string.chocolatecake), context.getString(R.string.flour),"220 grams"),
            DetailsIngredientModel(
                R.drawable.img_cocoa, context.getString(R.string.chocolatecake), context.getString(R.string.cocoa),"65 grams"),
            DetailsIngredientModel(
                R.drawable.img_baking_powder, context.getString(R.string.chocolatecake), context.getString(R.string.baking_powder),"7 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.chocolatecake), context.getString(R.string.salt),"5 grams"),
            DetailsIngredientModel(
                R.drawable.img_eggs, context.getString(R.string.chocolatecake), context.getString(R.string.eggs), "2"),
            DetailsIngredientModel(
                R.drawable.img_milk, context.getString(R.string.chocolatecake), context.getString(R.string.milk),"240 ml"),
            DetailsIngredientModel(
                R.drawable.img_olive, context.getString(R.string.chocolatecake), context.getString(R.string.olive),"120 ml"),



            DetailsIngredientModel(
                R.drawable.img_sugar, context.getString(R.string.cheesecake), context.getString(R.string.sugar),"50 grams"),
            DetailsIngredientModel(
                R.drawable.img_butter, context.getString(R.string.cheesecake), context.getString(R.string.butter),"115 grams"),
            DetailsIngredientModel(
                R.drawable.img_eggs, context.getString(R.string.cheesecake), context.getString(R.string.eggs),"4"),
            DetailsIngredientModel(
                R.drawable.img_smetana, context.getString(R.string.cheesecake), context.getString(R.string.smetana),"160 ml"),
            DetailsIngredientModel(
                R.drawable.img_cream, context.getString(R.string.cheesecake), context.getString(R.string.cream),"160 ml"),



            DetailsIngredientModel(
                R.drawable.img_flour, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.flour),"220 grams"),
            DetailsIngredientModel(
                R.drawable.img_sugar, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.sugar),"350 grams"),
            DetailsIngredientModel(
                R.drawable.img_cocoa, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.cocoa),"65 grams"),
            DetailsIngredientModel(
                R.drawable.img_baking_powder, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.baking_powder),"50 grams"),
            DetailsIngredientModel(
                R.drawable.img_soda, context.getString(R.string.classic_chocolate_cake), context.getString(
                                    R.string.soda),"50 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.salt),"30 grams"),
            DetailsIngredientModel(
                R.drawable.img_eggs, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.salt),"2"),
            DetailsIngredientModel(
                R.drawable.img_olive, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.olive),"120 ml"),
            DetailsIngredientModel(
                R.drawable.img_milk, context.getString(R.string.classic_chocolate_cake), context.getString(R.string.milk),"120 ml"),


            DetailsIngredientModel(
                R.drawable.img_milk, context.getString(R.string.homemade_bread), context.getString(R.string.milk),"125 ml"),
            DetailsIngredientModel(
                R.drawable.img_sugar, context.getString(R.string.homemade_bread), context.getString(R.string.sugar),"25 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.homemade_bread), context.getString(R.string.sugar),"10 grams"),
            DetailsIngredientModel(
                R.drawable.img_flour, context.getString(R.string.homemade_bread), context.getString(R.string.flour),"500 grams"),
            DetailsIngredientModel(
                R.drawable.img_baking_powder, context.getString(R.string.homemade_bread), context.getString(R.string.baking_powder),"5 grams"),




            DetailsIngredientModel(
                R.drawable.img_cucumber_salat, context.getString(R.string.cucumber_and_tomato_salad), context.getString(
                                    R.string.cucumber),"2"),
            DetailsIngredientModel(
                R.drawable.img_tomatoes, context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.tomatoes),"2"),
            DetailsIngredientModel(
                R.drawable.img_parsley, context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.tomatoes),"2"),
            DetailsIngredientModel(
                R.drawable.img_olive, context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.olive),"40 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.salt),"20 grams"),
            DetailsIngredientModel(
                R.drawable.img_garlic, context.getString(R.string.cucumber_and_tomato_salad), context.getString(
                                    R.string.garlic),"1"),



            DetailsIngredientModel(
                R.drawable.img_cucumber_salat, context.getString(R.string.caesar_salad), context.getString(R.string.cucumber),"2"),
            DetailsIngredientModel(
                R.drawable.img_tomatoes, context.getString(R.string.caesar_salad), context.getString(R.string.tomatoes),"2"),
            DetailsIngredientModel(
                R.drawable.img_parsley, context.getString(R.string.caesar_salad), context.getString(R.string.tomatoes),"2"),
            DetailsIngredientModel(
                R.drawable.img_olive, context.getString(R.string.caesar_salad), context.getString(R.string.olive),"40 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.caesar_salad), context.getString(R.string.salt),"20 grams"),
            DetailsIngredientModel(
                R.drawable.img_garlic, context.getString(R.string.caesar_salad), context.getString(R.string.garlic),"1"),


            DetailsIngredientModel(
                R.drawable.img_potatoes, context.getString(R.string.chips), context.getString(R.string.potatoes),"2"),
            DetailsIngredientModel(
                R.drawable.img_olive, context.getString(R.string.chips), context.getString(R.string.olive),"30 grams"),
            DetailsIngredientModel(
                R.drawable.img_salt, context.getString(R.string.chips), context.getString(R.string.salt),"10 grams"),


            )
    }

    override fun getSteps(): List<InfoStepsModel> {
        return listOf(InfoStepsModel(
            //Chocolate Cake"
            context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step1),
            context.getString(R.string.chocolatecake_info1)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step2),
                context.getString(R.string.chocolatecake_info2)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step3),
                context.getString(R.string.chocolatecake_info3)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step4),
                context.getString(R.string.chocolatecake_info4)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step5),
                context.getString(R.string.chocolatecake_info5)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step6),
                context.getString(R.string.chocolatecake_info6)),
            InfoStepsModel(
                context.getString(R.string.chocolatecake), context.getString(R.string.chocolatecake_step7),
                context.getString(R.string.chocolatecake_info7)),


            //Cheesecake
            InfoStepsModel(
                context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step1),
                context.getString(R.string.cheesecake_info1)),
            InfoStepsModel(
                context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step2),
                context.getString(R.string.cheesecake_info2)),
            InfoStepsModel(
                context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step3),
                context.getString(R.string.cheesecake_info3)),
            InfoStepsModel(
                context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step4),
                context.getString(R.string.cheesecake_info4)),
            InfoStepsModel(
                context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step5),
                context.getString(R.string.cheesecake_info5)),

        InfoStepsModel(
            context.getString(R.string.cheesecake), context.getString(R.string.cheesecake_step6),
                context.getString(R.string.cheesecake_info6)),



            //Classic Chocolate Cake
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step1),
                context.getString(R.string.classk_chocolate_info1)),
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step2),
                context.getString(R.string.classk_chocolate_info2)),
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step3),
                context.getString(R.string.classk_chocolate_info3)),
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step4),
                context.getString(R.string.classk_chocolate_info4)),
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step5),
                context.getString(R.string.classk_chocolate_info5)),
            InfoStepsModel(
                context.getString(R.string.classic_chocolate_cake), context.getString(R.string.classk_chocolate_step6),
                context.getString(R.string.classk_chocolate_info6)),


            //Homemade Bread
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step1),
                context.getString(R.string.homemade_sinfo1)),

            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step2),
                context.getString(R.string.homemade_sinfo2)),

            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step3),
                context.getString(R.string.homemade_sinfo3)),
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step4),
                context.getString(R.string.homemade_sinfo4)),

            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step5),
                context.getString(R.string.homemade_sinfo5)),
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step6),
                context.getString(R.string.homemade_sinfo6)),
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step7),
                context.getString(R.string.homemade_sinfo7)),
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step8),
                context.getString(R.string.homemade_sinfo8)),
            InfoStepsModel(
                context.getString(R.string.homemade_bread), context.getString(R.string.homemade_step9),
                context.getString(R.string.homemade_sinfo9)),


            //Cucumber and Tomato Salad

            InfoStepsModel(
                context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.cucumber_step1),
                context.getString(R.string.cucumber_info1)),

            InfoStepsModel(
                context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.cucumber_step2),
                context.getString(R.string.cucumber_info2)),


            InfoStepsModel(
                context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.cucumber_step3),
                context.getString(R.string.cucumber_info3)),


            InfoStepsModel(
                context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.cucumber_step4),
                context.getString(R.string.cucumber_info4)),
            InfoStepsModel(
                context.getString(R.string.cucumber_and_tomato_salad), context.getString(R.string.cucumber_step5),
                context.getString(R.string.cucumber_info5)),


            //Caesar Salad
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step1),
                context.getString(R.string.ceaser_salat_info1)),
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step2),
                context.getString(R.string.ceaser_salat_info2)),
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step3),
                context.getString(R.string.ceaser_salat_info3)),
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step4),
                context.getString(R.string.ceaser_salat_info4)),
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step5),
                context.getString(R.string.ceaser_salat_info5)),
            InfoStepsModel(
                context.getString(R.string.caesar_salad), context.getString(R.string.ceaser_salat_step6),
                context.getString(R.string.ceaser_salat_info6)),

            //Chips
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step1),
                context.getString(R.string.chips_info1)),

            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step2),
                context.getString(R.string.chips_info2)),
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step3),
                context.getString(R.string.chips_info3)),
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step4),
                context.getString(R.string.chips_info_4)),
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step5),
                context.getString(R.string.chips_info_5)),
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.chips_step6),
                context.getString(R.string.info_chips6)),
            InfoStepsModel(
                context.getString(R.string.chips), context.getString(R.string.step7_chips),
                context.getString(R.string.info_chips)),


            )
    }

    override fun search(query: String): List<HomeModel1> {
        val search = getHome1().filter {
            it.nameFood.contains(query, ignoreCase = true)
        }
        Log.d("FoodRepository", "Результаты поиска для запроса '$query': $search")
        return search
    }
}