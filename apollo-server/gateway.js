const {ApolloServer} = require("apollo-server");
const {ApolloGateway, RemoteGraphQLDataSource} = require("@apollo/gateway");

class AuthenticatedDataSource extends RemoteGraphQLDataSource {
    willSendRequest({request, context}) {
        request.http.headers.set('Authorization', context.authHeaderValue);
    }
}

const gateway = new ApolloGateway({
    serviceList: [
        {name: "shows-service", url: "http://localhost:8080/graphql"},
        {name: "review-service", url: "http://localhost:8089/graphql"}
    ],
    buildService({name, url}) {
        return new AuthenticatedDataSource({url});
    },
});

const server = new ApolloServer({
    gateway, subscriptions: false, context: ({req}) => ({
        authHeaderValue: req.headers.authorization
    })
});

server.listen().then(({url}) => {
    console.log(`🚀 Server ready at ${url}`);
});
