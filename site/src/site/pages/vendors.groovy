layout 'layouts/main.groovy', true,
        pageTitle: 'Vendors - SDKMAN!',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/vendor-navbar.groovy'
                            br()
                        }

                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                a(name: 'main'){}
                                i(class: 'fa fa-briefcase'){}
                                yield ' Vendors'
                            }

                            article {
                                p {
                                    yield 'SDKMAN! is unique in that it empowers SDK Vendors to publish their own Candidate '
                                    yield 'releases on our platform. We provide a secure API that can be used to manage '
                                    yield 'all aspects of a release on SDKMAN!. This includes '
                                    strong 'Releasing'
                                    yield ' a new Version, '
                                    yield 'setting an existing Version as '
                                    strong 'Default'
                                    yield ' (Stable) and '
                                    strong 'Announcing'
                                    yield ' the release '
                                    yield 'on the SDKMAN! CLI broadcast and Twitter feed.'
                                }
                            }

                            article {
                                a(name: 'operations'){}
                                h3 { yield 'Operations' }
                                p {
                                    yield 'The API is a simple JSON REST API that allows several operations:'
                                    ul {
                                        li { yield 'Release a new Candidate Version' }
                                        li { yield 'Make a Version the Default for a given Candidate' }
                                        li { yield 'Broadcast a structured release message' }
                                        li { yield 'Broadcast a freeform message' }
                                    }
                                }
                            }

                            article {
                                a(name: 'access'){}
                                h3 { yield 'Access' }
                                p { 
                                    yield '''This is a secured API, and requires appropriate credentials to perform the above operations. Access will be granted on a 
                                    case-by-case basis to Vendors who are interested in making their technology available on SDKMAN!. If you want to publish your releases 
                                    on SDKMAN!, please contact ''' 
                                    a(href: 'mailto:marco@sdkman.io', 'Marco Vermeulen')
                                    yield ' to help getting you on board.'
                                }                             
                            }

                            article {
                                a(name: 'endpoints'){}
                                h3 { yield 'Endpoints' }
                                yield 'The simplest way to call the API is by using cURL. Of course, any other client can be used to perform the API operations:'
                                p {
                                    h4 { yield 'Release a new Candidate Version' }
                                    yield 'This will perform a Minor Release on SDKMAN!. It will simply add the new Candidate Version, but will not make it the default version for the Candidate.'
                                    pre {
                                        code '''
curl -X POST \\
    -H "Consumer-Key: CONSUMER_KEY" \\
    -H "Consumer-Token: CONSUMER_TOKEN" \\
    -H "Content-Type: application/json" \\
    -H "Accept: application/json" \\
    -d '{"candidate": "groovy", "version": "2.4.2", "url": "http://dl.bintray.com/groovy/maven/groovy-binary-2.4.2.zip"}' \\
    https://vendors.sdkman.io/release
                                        '''
                                    }
                                }
                                br()

                                p {
                                    h4 { yield 'Set existing Version as Default for Candidate' }
                                    yield 'When calling this endpoint for an existing Candidate Version, it will make it the Default Version for that Candidate. This makes a Minor release a Major release!'
                                    pre {
                                        code '''
curl -X PUT \\
    -H "Consumer-Key: CONSUMER_KEY" \\
    -H "Consumer-Token: CONSUMER_TOKEN" \\
    -H "Content-Type: application/json" \\
    -H "Accept: application/json" \\
    -d '{"candidate": "groovy", "version": "2.3.8"}' \\
    https://vendors.sdkman.io/default
                                        '''
                                    }
                                }
                                br()

                                p {
                                    h4 { yield 'Broadcast a Structured Message' }
                                    yield 'This will result in a structured message announcement on social media and SDKMAN! CLI. The result will look something like: '
                                    code 'Grails 3.0.0 has been released on SDKMAN! #grailsfw'
                                    yield'. This message will be announced to the broadcast channel of SDKMAN! CLI, as well as on the '
                                    a(href: 'https://www.twitter.com/sdkman_', '@sdkman_')
                                    yield ' Twitter feed.'
                                    pre {
                                        code '''
curl -X POST \\
    -H "Consumer-Key: CONSUMER_KEY" \\
    -H "Consumer-Token: CONSUMER_TOKEN" \\
    -H "Content-Type: application/json" \\
    -H "Accept: application/json" \\
    -d '{"candidate": "grails", "version": "3.0.0", "hashtag": "grailsfw"}' \\
    https://vendors.sdkman.io/announce/struct
                                        '''
                                    }
                                }
                                br()

                                p {
                                    h4 { yield 'Broadcast a Freeform Message' }
                                    yield 'This endpoint is not used as much as the previous, but allows freeform messages to be announced.'
                                    pre {
                                        code '''
curl -X POST \\
    -H "Consumer-Key: CONSUMER_KEY" \\
    -H "Consumer-Token: CONSUMER_TOKEN" \\
    -H "Content-Type: application/json" \\
    -H "Accept: application/json" \\
    -d '{"text": "SDKMAN! 2.4.0 rolling out. Broadcast and Offline checks optimised."}' \\
    https://vendors.sdkman.io/announce/freeform
                                        '''
                                    }
                                }
                                br()
                            }

                            article {
                                a(name: 'gradleplugin'){}
                                h3 { yield 'Gradle SDK Vendor Plugin' }
                                p {
                                    yield 'If fiddling with cURL (or HttpClient) isn’t your thing, you could consider using our Gradle plugin. The plugin allows the release to be done as a side effect of your CI build! It exposes several useful tasks like:'
                                    ul {
                                        li {code 'sdkReleaseVersion' }
                                        li {code 'sdkDefaultVersion' }
                                        li {code 'sdkAnnounceVersion' }
                                    }
                                    yield 'It also exposes some convenience tasks that roll the above into single tasks:'
                                    ul {
                                        li {
                                            code 'sdkMajorRelease'
                                            yield ': performs release, default and structured announce'
                                        }
                                        li {
                                            code 'sdkMinorRelease'
                                            yield ': performs release and structured announce, '
                                            em 'no'
                                            yield ' default'
                                        }
                                    }
                                    yield 'For more details of about this plugin, as well as how to configure it, please refer to the '
                                    a(href: 'https://github.com/sdkman/gradle-sdkvendor-plugin', 'Github Page')
                                    yield ' for the project.'
                                }
                            }
                        }
                    }
                }
            }
        }
