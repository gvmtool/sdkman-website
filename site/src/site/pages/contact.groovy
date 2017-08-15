layout 'layouts/main.groovy', true,
        pageTitle: 'Contact with us',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {}
                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                yield 'Get in touch!'
                            }
                            article(class: 'contact-form') {
                                form(enctype: 'application/json') {
                                    div(class: 'form-group') {
                                        input(class: 'form-control contact-input', name: 'name', type: 'text', placeholder: 'Name') {}
                                        input(class: 'form-control contact-input', name: 'email', type: 'email', placeholder: 'Email') {}
                                        textarea(class: 'form-control contact-input', name: 'message', type: 'text', rows: 3, placeholder: 'Message') {}
                                    }
                                    submit(class: 'btn btn-primary contact-btn', type: 'submit') {
                                        yield 'Submit'
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
