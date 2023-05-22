//
//  ArticlesViewModel.swift
//  iosApp
//
//  Created by Shoorei, Shervin on 21/05/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class ArticlesViewModel : ObservableObject {
    @Published var articles: [Article] = []
    let repository = KotlinWeeklyRepository()
    
    func getArticles() {
        repository.getArticles() { [self] (articles, error) in
            if let a = articles {
                print("RECEIVED: \(a)")
                self.articles = a
            } else {
                self.articles = []
                print("ERROR")
            }
        }
    }
}
