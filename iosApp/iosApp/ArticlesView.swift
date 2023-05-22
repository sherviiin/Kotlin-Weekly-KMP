import SwiftUI
import shared

struct ArticlesView: View {
    
    @StateObject private var viewModel: ArticlesViewModel

    init() {
        _viewModel = StateObject(wrappedValue: ArticlesViewModel())
    }
    
    var body: some View {
        
        List(viewModel.articles) { article in
            
            VStack(alignment: .leading, spacing: 28){
                Text(article.title).font(.headline)
                    .fontWeight(.bold)
                Text(article.description_).font(.body)
                Text(article.link).font(.caption)
                    .fontWeight(.light).onTapGesture {
                        openURL(article.link)
                    }
            }
        }
            .onAppear(){
            viewModel.getArticles()
        }
    }
    
    func openURL(_ urlString: String) {
            if let url = URL(string: urlString) {
                UIApplication.shared.open(url)
            }
        }
}

extension Article : Identifiable {
    public var id: String {
            return link
        }
}

struct ArticleView_Preview: PreviewProvider {
    static var previews: some View {
        ArticlesView()
    }
}
