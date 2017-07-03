layout 'layouts/main.groovy', true,
        pageTitle: 'Usage - SDKMAN!',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/usage-navbar.groovy'
                            br()
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                a(name: 'main'){}
                                i(class: 'fa fa-laptop'){}
                                yield ' Usage'
                            }

                            include template: 'pages/usage/install.groovy'
                            include template: 'pages/usage/remove.groovy'
                            include template: 'pages/usage/list.groovy'
                            include template: 'pages/usage/use.groovy'
                            include template: 'pages/usage/default.groovy'
                            include template: 'pages/usage/current.groovy'
                            include template: 'pages/usage/outdated.groovy'
                            include template: 'pages/usage/version.groovy'
                            include template: 'pages/usage/broadcast.groovy'
                            include template: 'pages/usage/offline.groovy'
                            include template: 'pages/usage/selfupdate.groovy'
                            include template: 'pages/usage/flush.groovy'
                            include template: 'pages/usage/help.groovy'
                            include template: 'pages/usage/config.groovy'
                        }
                    }
                }
            }
        }
