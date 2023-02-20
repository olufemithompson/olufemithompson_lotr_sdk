
## System Design

The sdk provides a set of classes that provides functionality for making API calls to https://the-one-api.dev/.

The current implementation only support synchronous calls. For now support for asynchronous calls with the use of callbacks is not provided.

This sdk is build on a set of base classes from which classes that implement services that are consumed on corresponding endpoints(/movie, /book e.t.c), are built on.


Below are the following set of base classes

#### com.liblab.lotrsdk.BaseAPI
This is an abstract class that exposes functions to make API calls  to the API server. For each service(movie, books e.t.c), corresponding Implementation classes are created from this base class with functions for each of those service

#### com.liblab.lotrsdk.ApiRequest
This is an abstract class that represents all http requests/information(endpoint, params, headers e.t.c) made to the API server.

#### com.liblab.lotrsdk.BaseListApiRequest
This is another abstract class that extends the **com.liblab.lotrsdk.ApiRequest** class, but provides additional functionality to support any API request that requires sorting, filtering, pagination(e.g /movie, /book). So all Implementation of the ApiRequest object that support those kind of request extends this class instead.

#### com.liblab.lotrsdk.ApiResponse
This is an abstract class that represents all http response coming from the API server.
For each service, we have corresponding Sub classes of this class that implementations specific to the actual response object type that is returned

#### com.liblab.lotrsdk.BaseListModel
This is a model class that represents all response from the API server that includes pagination information. i.e all api endpoints that returns a list of objects. So specific object models that represents a list as sent from the API extends this class.


#### Service implementations
ALl service implementations(movie, book) for the API are provided in the **com.liblab.lotrsdk.services** package

Under that package we have
- book service : com.liblab.lotrsdk.services.book
- movie service : com.liblab.lotrsdk.services.movie 












