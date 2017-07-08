layout 'layouts/main.groovy', true,
        pageTitle: 'Available SDKs - SDKMAN!',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {}

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                a(name: 'main'){}
                                i(class: 'fa fa-cloud-download'){}
                                yield ' SDK Installation Candidates'
                            }

                            include unescaped: 'html/candidates.html'
                        }
                    }
                }
            }
        }
