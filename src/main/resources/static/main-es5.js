(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/app.component.html":
/*!**************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/app.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\r\n\r\n<div class=\"container m-5\">\r\n\r\n\r\n    <router-outlet></router-outlet>\r\n\r\n\r\n</div>"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/callback/callback.component.html":
/*!***************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/callback/callback.component.html ***!
  \***************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\r\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/compras/compras.component.html":
/*!*************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/compras/compras.component.html ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form (ngSubmit)=\"guardar(forma)\" #forma=\"ngForm\" novalidate=\"\">\r\n    <div class=\"form-group\">\r\n        <label for=\"producto\">Código de Producto</label>\r\n        <input [(ngModel)]=\"compra.codProducto\" type=\"text\" class=\"form-control\" name=\"codProducto\" placeholder=\"Ingrese el código de producto\">\r\n    </div>\r\n    <div class=\"form-group\">\r\n        <label for=\"cantidad\">Cantidad</label>\r\n        <input [(ngModel)]=\"compra.cantidad\" type=\"number\" class=\"form-control\" name=\"cantidad\" placeholder=\"Ingrese la cantidad\" min=\"0\" max=\"1000\">\r\n    </div>\r\n    <div class=\"form-group\">\r\n        <label for=\"costo\">Costo</label>\r\n        <input [(ngModel)]=\"compra.costo\" type=\"number\" class=\"form-control\" name=\"costo\" placeholder=\"Ingrese el costo\" min=\"0.00\" max=\"10000.00\" step=\"0.01\">\r\n    </div>\r\n    <button [disabled]=\"!forma.valid\" type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n</form>\r\n<br /><br /><br />\r\n<div *ngIf=\"error\" class=\"card text-white bg-danger mb-3\">\r\n  <h5 class=\"card-title\">Error</h5>\r\n  <p class=\"card-text\">{{message}}</p>\r\n</div>\r\n\r\n<div *ngIf=\"operacionOk\" class=\"card text-white bg-success mb-3\">\r\n  <h5 class=\"card-title\">Operación Exitosa</h5>\r\n</div>\r\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/home/home.component.html":
/*!*******************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/home/home.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"auth.userProfile$ | async as profile\">\r\n  <div class=\"col-md-16\">\r\n    <h1>Bienvenido !!! {{ profile.name }}</h1>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/inventario/inventario.component.html":
/*!*******************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/inventario/inventario.component.html ***!
  \*******************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-loading *ngIf=\"loading\"></app-loading>\r\n\r\n<div *ngIf=\"!loading\" class=\"row animated fadeIn\">\r\n\r\n  <div class=\"col-8\">\r\n    <h3>Listado de Productos</h3>\r\n  </div>\r\n  <div class=\"col-4 text-right\">\r\n    <button routerLink=\"/search\" class=\"btn btn-outline-danger\">Regresar</button>\r\n  </div>\r\n</div>\r\n\r\n<div *ngIf=\"!loading\" class=\"row\">\r\n  <div class=\"col\">\r\n    <table class=\"table\">\r\n      <thead>\r\n        <tr>\r\n          <th>Código de Producto</th>\r\n          <th>Descripción</th>\r\n          <th>Tipo Superheroe</th>\r\n          <th>Costo</th>\r\n          <th>Stock</th>\r\n          <th>Fecha última actualización</th>          \r\n        </tr>\r\n      </thead>\r\n      <tbody>\r\n        <tr *ngFor=\"let item of inventario\" class=\"text-black\">\r\n          <td>{{item.producto.codProducto}}</td>\r\n          <td>{{item.producto.descripcion}}</td>\r\n          <td>{{item.producto.tipoSuperheroe.nombre}}</td>\r\n          <td>{{item.producto.costo}}</td>          \r\n          <td>{{item.stock}}</td>\r\n          <td>{{item.fechaUltimaActualizacion  | date:'medium' }}</td>          \r\n        </tr>\r\n      </tbody>\r\n\r\n    </table>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/kardex/kardex.component.html":
/*!***********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/kardex/kardex.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row m-5\">\r\n  <div class=\"col\">\r\n    <input #codproducto type=\"text\" (keyup)=\"buscar(codproducto.value)\" class=\"form-control\"\r\n      placeholder=\"Buscar producto...\">\r\n  </div>\r\n</div>\r\n\r\n<br />\r\n<div *ngIf=\"error\" class=\"card text-white bg-danger mb-3\">\r\n  <h5 class=\"card-title\">Error</h5>\r\n  <p class=\"card-text\">{{message}}</p>\r\n</div>\r\n<br />\r\n\r\n<app-loading *ngIf=\"loading\"></app-loading>\r\n\r\n<div *ngIf=\"!loading\" class=\"row animated fadeIn\">\r\n  <div class=\"col-8 m5\">\r\n    <h3>Kardex de Producto {{codProducto}}</h3>\r\n  </div>\r\n  <div class=\"col-4 text-right\">\r\n    <button routerLink=\"/search\" class=\"btn btn-outline-danger\">Regresar</button>\r\n  </div>\r\n</div>\r\n\r\n<div *ngIf=\"!loading && kardex.length > 0\" class=\"row\">\r\n  <div class=\"col\">\r\n    <table class=\"table\">\r\n      <thead>\r\n        <tr>\r\n          <th>Fecha</th>\r\n          <th>Codigo Producto</th>\r\n          <th>Descripción Producto</th>\r\n          <th>Operacion</th>\r\n          <th>Valor Unitario</th>\r\n          <th>Entrada Cantidad</th>\r\n          <th>Entrada Total</th>\r\n          <th>Salida Cantidad</th>\r\n          <th>Salida Total</th>\r\n          <th>Saldo Cantidad</th>\r\n          <th>Saldo Total</th>\r\n        </tr>\r\n      </thead>\r\n      <tbody>\r\n        <tr *ngFor=\"let item of kardex\" class=\"text-black\">\r\n          <td>{{item.fecha | date:'medium'}}</td>\r\n          <td>{{item.producto.codProducto}}</td>\r\n          <td>{{item.producto.descripcion}}</td>\r\n          <td>{{item.tipoOperacion.descripcion}}</td>\r\n          <td>{{item.valorUnitario | currency:'USD':'symbol':'0.2'}}</td>\r\n          <td>{{item.entrada.cantidad}}</td>\r\n          <td>{{item.entrada.total | currency:'USD':'symbol':'0.2'}}</td>\r\n          <td>{{item.salida.cantidad}}</td>\r\n          <td>{{item.salida.total | currency:'USD':'symbol':'0.2'}}</td>\r\n          <td class=\"table-primary\">{{item.saldo.cantidad}}</td>\r\n          <td class=\"table-primary\">{{item.saldo.total  | currency:'USD':'symbol':'0.2'}}</td>\r\n        </tr>\r\n      </tbody>\r\n\r\n    </table>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/loading/loading.component.html":
/*!*************************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/loading/loading.component.html ***!
  \*************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row text-center animated fadeIn m-5\">\r\n    <div class=\"col\">\r\n        <i class=\"fa fa-sync fa-spin fa-5x\"></i>\r\n    </div>\r\n  </div>\r\n  "

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/navbar/navbar.component.html":
/*!***********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/navbar/navbar.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\"\r\n    aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n    <span class=\"navbar-toggler-icon\"></span>\r\n  </button>\r\n  <a class=\"navbar-brand\" href=\"#\">\r\n    <img src=\"assets/img/todo1.jpg\" width=\"130\" height=\"60\" alt=\"\"> Hulk Store</a>\r\n  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n    <ul class=\"navbar-nav mr-auto\">\r\n      <li class=\"nav-item\" routerLinkActive=\"active\">\r\n        <a class=\"nav-link\" [routerLink]=\"['home']\">Home <span class=\"sr-only\">(current)</span></a>\r\n      </li>\r\n      <li *ngIf=\"!isAuthenticated()\" class=\"nav-item\" routerLinkActive=\"active\">\r\n        <a class=\"nav-link\" [routerLink]=\"['inventario']\">Inventario</a>\r\n      </li>\r\n      <li *ngIf=\"!isAuthenticated()\" class=\"nav-item\" routerLinkActive=\"active\">\r\n        <a class=\"nav-link\" [routerLink]=\"['kardex']\">Kardex</a>\r\n      </li>\r\n      <li *ngIf=\"!isAuthenticated()\" class=\"nav-item\" routerLinkActive=\"active\">\r\n        <a class=\"nav-link\" [routerLink]=\"['compras']\">Compras de Productos</a>\r\n      </li>\r\n      <li *ngIf=\"!isAuthenticated()\" class=\"nav-item\" routerLinkActive=\"active\">\r\n        <a class=\"nav-link\" [routerLink]=\"['ventas']\">Ventas de Productos</a>\r\n      </li>\r\n    </ul>\r\n<!--\r\n    <span class=\"navbar-text\">\r\n      <button *ngIf=\"!isAuthenticated()\" (click)=\"login()\" type=\"button\" class=\"btn btn-outline-primary\">Login</button>\r\n    </span>\r\n\r\n    <span class=\"navbar-text\">\r\n      <button *ngIf=\"isAuthenticated()\" (click)=\"logout()\" type=\"button\" class=\"btn btn-outline-primary\">Logout</button>\r\n    </span>\r\n  -->\r\n  </div>\r\n</nav>\r\n"

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/components/ventas/ventas.component.html":
/*!***********************************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/components/ventas/ventas.component.html ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form (ngSubmit)=\"guardar(forma)\" #forma=\"ngForm\" novalidate=\"\">\r\n  <div class=\"form-group\">\r\n    <label for=\"producto\">Código de Producto</label>\r\n    <input [(ngModel)]=\"venta.codProducto\" type=\"text\" class=\"form-control\" name=\"codProducto\"\r\n      placeholder=\"Ingrese el código de producto\">\r\n  </div>\r\n  <div class=\"form-group\">\r\n    <label for=\"cantidad\">Cantidad</label>\r\n    <input [(ngModel)]=\"venta.cantidad\" type=\"number\" class=\"form-control\" name=\"cantidad\"\r\n      placeholder=\"Ingrese la cantidad\" min=\"0\" max=\"1000\">\r\n  </div>\r\n  <div class=\"form-group\">\r\n    <label for=\"costo\">Precio Venta</label>\r\n    <input [(ngModel)]=\"venta.costo\" type=\"number\" class=\"form-control\" name=\"costo\" placeholder=\"Ingrese precio venta\"\r\n      min=\"0.00\" max=\"10000.00\" step=\"0.01\">\r\n  </div>\r\n  <button [disabled]=\"!forma.valid\" type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n</form>\r\n<br /><br /><br />\r\n<div *ngIf=\"error\" class=\"card text-white bg-danger mb-3\">\r\n  <h5 class=\"card-title\">Error</h5>\r\n  <p class=\"card-text\">{{message}}</p>\r\n</div>\r\n\r\n<div *ngIf=\"operacionOk\" class=\"card text-white bg-success mb-3\">\r\n  <h5 class=\"card-title\">Operación Exitosa</h5>\r\n</div>\r\n"

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'authapp';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/index.js!./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/navbar/navbar.component */ "./src/app/components/navbar/navbar.component.ts");
/* harmony import */ var _components_home_home_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/home/home.component */ "./src/app/components/home/home.component.ts");
/* harmony import */ var _app_routes__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app.routes */ "./src/app/app.routes.ts");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./services/auth.service */ "./src/app/services/auth.service.ts");
/* harmony import */ var _components_callback_callback_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/callback/callback.component */ "./src/app/components/callback/callback.component.ts");
/* harmony import */ var _services_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./services/auth-guard.service */ "./src/app/services/auth-guard.service.ts");
/* harmony import */ var _components_inventario_inventario_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./components/inventario/inventario.component */ "./src/app/components/inventario/inventario.component.ts");
/* harmony import */ var _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./components/kardex/kardex.component */ "./src/app/components/kardex/kardex.component.ts");
/* harmony import */ var _components_compras_compras_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./components/compras/compras.component */ "./src/app/components/compras/compras.component.ts");
/* harmony import */ var _components_ventas_ventas_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./components/ventas/ventas.component */ "./src/app/components/ventas/ventas.component.ts");
/* harmony import */ var _services_kardex_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./services/kardex.service */ "./src/app/services/kardex.service.ts");
/* harmony import */ var _components_loading_loading_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./components/loading/loading.component */ "./src/app/components/loading/loading.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");


















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__["NavbarComponent"],
                _components_home_home_component__WEBPACK_IMPORTED_MODULE_5__["HomeComponent"],
                _components_callback_callback_component__WEBPACK_IMPORTED_MODULE_8__["CallbackComponent"],
                _components_inventario_inventario_component__WEBPACK_IMPORTED_MODULE_10__["InventarioComponent"],
                _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_11__["KardexComponent"],
                _components_compras_compras_component__WEBPACK_IMPORTED_MODULE_12__["ComprasComponent"],
                _components_ventas_ventas_component__WEBPACK_IMPORTED_MODULE_13__["VentasComponent"],
                _components_loading_loading_component__WEBPACK_IMPORTED_MODULE_15__["LoadingComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_17__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_16__["HttpClientModule"],
                _app_routes__WEBPACK_IMPORTED_MODULE_6__["APP_ROUTING"]
            ],
            providers: [_services_auth_service__WEBPACK_IMPORTED_MODULE_7__["AuthService"], _services_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__["AuthGuardService"], _services_kardex_service__WEBPACK_IMPORTED_MODULE_14__["KardexService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/app.routes.ts":
/*!*******************************!*\
  !*** ./src/app/app.routes.ts ***!
  \*******************************/
/*! exports provided: APP_ROUTING, FeatureRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "APP_ROUTING", function() { return APP_ROUTING; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FeatureRoutingModule", function() { return FeatureRoutingModule; });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _components_home_home_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./components/home/home.component */ "./src/app/components/home/home.component.ts");
/* harmony import */ var _components_callback_callback_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/callback/callback.component */ "./src/app/components/callback/callback.component.ts");
/* harmony import */ var _components_inventario_inventario_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/inventario/inventario.component */ "./src/app/components/inventario/inventario.component.ts");
/* harmony import */ var _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/kardex/kardex.component */ "./src/app/components/kardex/kardex.component.ts");
/* harmony import */ var _components_compras_compras_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/compras/compras.component */ "./src/app/components/compras/compras.component.ts");
/* harmony import */ var _components_ventas_ventas_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/ventas/ventas.component */ "./src/app/components/ventas/ventas.component.ts");







var APP_ROUTES = [
    { path: 'callback', component: _components_callback_callback_component__WEBPACK_IMPORTED_MODULE_2__["CallbackComponent"] },
    { path: 'home', component: _components_home_home_component__WEBPACK_IMPORTED_MODULE_1__["HomeComponent"] },
    {
        path: 'inventario',
        component: _components_inventario_inventario_component__WEBPACK_IMPORTED_MODULE_3__["InventarioComponent"]
        //,canActivate: [AuthGuardService]
    },
    {
        path: 'kardex',
        component: _components_kardex_kardex_component__WEBPACK_IMPORTED_MODULE_4__["KardexComponent"]
        //, canActivate: [AuthGuardService]
    },
    {
        path: 'compras',
        component: _components_compras_compras_component__WEBPACK_IMPORTED_MODULE_5__["ComprasComponent"]
        //, canActivate: [AuthGuardService]
    },
    {
        path: 'ventas',
        component: _components_ventas_ventas_component__WEBPACK_IMPORTED_MODULE_6__["VentasComponent"]
        //, canActivate: [AuthGuardService]
    },
    { path: '**', pathMatch: 'full', redirectTo: 'home' }
];
var APP_ROUTING = _angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(APP_ROUTES);
var FeatureRoutingModule = /** @class */ (function () {
    function FeatureRoutingModule() {
    }
    return FeatureRoutingModule;
}());



/***/ }),

/***/ "./src/app/components/callback/callback.component.ts":
/*!***********************************************************!*\
  !*** ./src/app/components/callback/callback.component.ts ***!
  \***********************************************************/
/*! exports provided: CallbackComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CallbackComponent", function() { return CallbackComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/services/auth.service */ "./src/app/services/auth.service.ts");



var CallbackComponent = /** @class */ (function () {
    function CallbackComponent(auth) {
        this.auth = auth;
    }
    CallbackComponent.prototype.ngOnInit = function () {
        this.auth.handleAuthCallback();
    };
    CallbackComponent.ctorParameters = function () { return [
        { type: src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"] }
    ]; };
    CallbackComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-callback',
            template: __webpack_require__(/*! raw-loader!./callback.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/callback/callback.component.html")
        })
    ], CallbackComponent);
    return CallbackComponent;
}());



/***/ }),

/***/ "./src/app/components/compras/compras.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/components/compras/compras.component.ts ***!
  \*********************************************************/
/*! exports provided: ComprasComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ComprasComponent", function() { return ComprasComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/services/kardex.service */ "./src/app/services/kardex.service.ts");



var ComprasComponent = /** @class */ (function () {
    function ComprasComponent(kardexService) {
        this.kardexService = kardexService;
        this.compra = {
            codProducto: null,
            cantidad: null,
            costo: null
        };
        this.operacionOk = false;
        this.error = false;
    }
    ComprasComponent.prototype.ngOnInit = function () {
    };
    ComprasComponent.prototype.guardar = function (forma) {
        var _this = this;
        this.kardexService.comprarProductos(forma.value).subscribe(function (data) {
            _this.error = false;
            _this.operacionOk = true;
        }, function (error) {
            _this.message = error.status + " " + error.error;
            _this.error = true;
            _this.operacionOk = false;
            console.log(error);
        });
    };
    ComprasComponent.ctorParameters = function () { return [
        { type: src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_2__["KardexService"] }
    ]; };
    ComprasComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-compras',
            template: __webpack_require__(/*! raw-loader!./compras.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/compras/compras.component.html"),
            styles: ["\n  .ng-invalid.ng-touched:not(form){\n    border: 1px solid red;\n  }\n  "]
        })
    ], ComprasComponent);
    return ComprasComponent;
}());



/***/ }),

/***/ "./src/app/components/home/home.component.ts":
/*!***************************************************!*\
  !*** ./src/app/components/home/home.component.ts ***!
  \***************************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/services/auth.service */ "./src/app/services/auth.service.ts");



var HomeComponent = /** @class */ (function () {
    function HomeComponent(auth) {
        this.auth = auth;
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent.ctorParameters = function () { return [
        { type: src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"] }
    ]; };
    HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! raw-loader!./home.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/home/home.component.html")
        })
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/components/inventario/inventario.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/components/inventario/inventario.component.ts ***!
  \***************************************************************/
/*! exports provided: InventarioComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InventarioComponent", function() { return InventarioComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/services/kardex.service */ "./src/app/services/kardex.service.ts");




var InventarioComponent = /** @class */ (function () {
    function InventarioComponent(router, kardexService) {
        var _this = this;
        this.router = router;
        this.kardexService = kardexService;
        this.inventario = {};
        this.router.params.subscribe(function (params) {
            _this.loading = true;
            _this.getInventario();
        });
    }
    InventarioComponent.prototype.ngOnInit = function () {
    };
    InventarioComponent.prototype.getInventario = function () {
        var _this = this;
        this.kardexService.getInventario().subscribe(function (inv) {
            _this.inventario = inv;
            _this.loading = false;
        }, function (error) {
            console.log("error");
            _this.loading = false;
        });
    };
    InventarioComponent.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
        { type: src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_3__["KardexService"] }
    ]; };
    InventarioComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-inventario',
            template: __webpack_require__(/*! raw-loader!./inventario.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/inventario/inventario.component.html")
        })
    ], InventarioComponent);
    return InventarioComponent;
}());



/***/ }),

/***/ "./src/app/components/kardex/kardex.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/components/kardex/kardex.component.ts ***!
  \*******************************************************/
/*! exports provided: KardexComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KardexComponent", function() { return KardexComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/services/kardex.service */ "./src/app/services/kardex.service.ts");




var KardexComponent = /** @class */ (function () {
    function KardexComponent(router, kardexService) {
        var _this = this;
        this.router = router;
        this.kardexService = kardexService;
        this.kardex = {};
        this.router.params.subscribe(function (params) {
            _this.loading = false;
            _this.error = false;
            _this.codProducto = '';
        });
    }
    KardexComponent.prototype.ngOnInit = function () {
    };
    KardexComponent.prototype.getKardex = function (codproducto) {
        var _this = this;
        this.kardexService.getKardex(codproducto).subscribe(function (kardex) {
            _this.kardex = kardex;
            _this.loading = false;
            _this.error = false;
        }, function (error) {
            _this.loading = false;
            _this.message = error;
            _this.message = error.status + " " + error.error;
            _this.error = true;
        });
    };
    KardexComponent.prototype.buscar = function (codproducto) {
        var _this = this;
        this.loading = true;
        this.kardexService.getProducto(codproducto).subscribe(function (data) {
            console.log(data);
            _this.codProducto = data.codProducto;
            _this.getKardex(codproducto);
            _this.loading = false;
            _this.error = false;
        }, function (error) {
            _this.loading = false;
            _this.message = error.status + " " + error.error;
            _this.error = true;
        });
    };
    KardexComponent.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
        { type: src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_3__["KardexService"] }
    ]; };
    KardexComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-kardex',
            template: __webpack_require__(/*! raw-loader!./kardex.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/kardex/kardex.component.html")
        })
    ], KardexComponent);
    return KardexComponent;
}());



/***/ }),

/***/ "./src/app/components/loading/loading.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/components/loading/loading.component.ts ***!
  \*********************************************************/
/*! exports provided: LoadingComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoadingComponent", function() { return LoadingComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var LoadingComponent = /** @class */ (function () {
    function LoadingComponent() {
    }
    LoadingComponent.prototype.ngOnInit = function () {
    };
    LoadingComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-loading',
            template: __webpack_require__(/*! raw-loader!./loading.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/loading/loading.component.html")
        })
    ], LoadingComponent);
    return LoadingComponent;
}());



/***/ }),

/***/ "./src/app/components/navbar/navbar.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/components/navbar/navbar.component.ts ***!
  \*******************************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/services/auth.service */ "./src/app/services/auth.service.ts");



var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(auth) {
        this.auth = auth;
    }
    NavbarComponent.prototype.ngOnInit = function () {
        this.auth.localAuthSetup();
    };
    NavbarComponent.prototype.isAuthenticated = function () {
        return this.auth.loggedIn;
    };
    NavbarComponent.prototype.login = function () {
        this.auth.login();
    };
    NavbarComponent.prototype.logout = function () {
        this.auth.logout();
    };
    NavbarComponent.ctorParameters = function () { return [
        { type: src_app_services_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"] }
    ]; };
    NavbarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! raw-loader!./navbar.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/navbar/navbar.component.html")
        })
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/components/ventas/ventas.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/components/ventas/ventas.component.ts ***!
  \*******************************************************/
/*! exports provided: VentasComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "VentasComponent", function() { return VentasComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/services/kardex.service */ "./src/app/services/kardex.service.ts");



var VentasComponent = /** @class */ (function () {
    function VentasComponent(kardexService) {
        this.kardexService = kardexService;
        this.venta = {
            codProducto: null,
            cantidad: null,
            costo: null
        };
        this.operacionOk = false;
        this.error = false;
    }
    VentasComponent.prototype.ngOnInit = function () {
    };
    VentasComponent.prototype.guardar = function (forma) {
        var _this = this;
        this.kardexService.venderProductos(forma.value).subscribe(function (data) {
            _this.error = false;
            _this.operacionOk = true;
        }, function (error) {
            console.log(error);
            _this.message = error.status + " " + error.error;
            _this.error = true;
            _this.operacionOk = false;
        });
    };
    VentasComponent.ctorParameters = function () { return [
        { type: src_app_services_kardex_service__WEBPACK_IMPORTED_MODULE_2__["KardexService"] }
    ]; };
    VentasComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-ventas',
            template: __webpack_require__(/*! raw-loader!./ventas.component.html */ "./node_modules/raw-loader/index.js!./src/app/components/ventas/ventas.component.html"),
            styles: ["\n  .ng-invalid.ng-touched:not(form){\n    border: 1px solid red;\n  }\n  "]
        })
    ], VentasComponent);
    return VentasComponent;
}());



/***/ }),

/***/ "./src/app/services/auth-guard.service.ts":
/*!************************************************!*\
  !*** ./src/app/services/auth-guard.service.ts ***!
  \************************************************/
/*! exports provided: AuthGuardService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuardService", function() { return AuthGuardService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./auth.service */ "./src/app/services/auth.service.ts");



var AuthGuardService = /** @class */ (function () {
    function AuthGuardService(auth) {
        this.auth = auth;
    }
    AuthGuardService.prototype.canActivate = function (next, state) {
        if (this.auth.loggedIn) {
            return true;
        }
        else {
            return false;
        }
    };
    AuthGuardService.ctorParameters = function () { return [
        { type: _auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"] }
    ]; };
    AuthGuardService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], AuthGuardService);
    return AuthGuardService;
}());



/***/ }),

/***/ "./src/app/services/auth.service.ts":
/*!******************************************!*\
  !*** ./src/app/services/auth.service.ts ***!
  \******************************************/
/*! exports provided: AuthService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthService", function() { return AuthService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _auth0_auth0_spa_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @auth0/auth0-spa-js */ "./node_modules/@auth0/auth0-spa-js/dist/auth0-spa-js.production.js");
/* harmony import */ var _auth0_auth0_spa_js__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_auth0_auth0_spa_js__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");






var AuthService = /** @class */ (function () {
    function AuthService(router) {
        this.router = router;
        // Create an observable of Auth0 instance of client
        this.auth0Client$ = Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["from"])(_auth0_auth0_spa_js__WEBPACK_IMPORTED_MODULE_2___default()({
            domain: "dev-ys93w65q.auth0.com",
            client_id: "nnYSyk0KQICzZwfZRPPJNWmI47asiwws",
            redirect_uri: window.location.origin + "/callback"
        })).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["shareReplay"])(1), // Every subscription receives the same shared value
        Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["catchError"])(function (err) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(err); }));
        // Define observables for SDK methods that return promises by default
        // For each Auth0 SDK method, first ensure the client instance is ready
        // concatMap: Using the client instance, call SDK method; SDK returns a promise
        // from: Convert that resulting promise into an observable
        this.isAuthenticated$ = this.auth0Client$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function (client) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["from"])(client.isAuthenticated()); }));
        this.handleRedirectCallback$ = this.auth0Client$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function (client) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["from"])(client.handleRedirectCallback()); }));
        // Create subject and public observable of user profile data
        this.userProfileSubject$ = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.userProfile$ = this.userProfileSubject$.asObservable();
        // Create a local property for login status
        this.loggedIn = null;
    }
    // getUser$() is a method because options can be passed if desired
    // https://auth0.github.io/auth0-spa-js/classes/auth0client.html#getuser
    AuthService.prototype.getUser$ = function (options) {
        return this.auth0Client$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function (client) { return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["from"])(client.getUser(options)); }));
    };
    AuthService.prototype.localAuthSetup = function () {
        var _this = this;
        // This should only be called on app initialization
        // Set up local authentication streams
        var checkAuth$ = this.isAuthenticated$.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function (loggedIn) {
            if (loggedIn) {
                // If authenticated, get user data
                return _this.getUser$();
            }
            // If not authenticated, return stream that emits 'false'
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(loggedIn);
        }));
        var checkAuthSub = checkAuth$.subscribe(function (response) {
            // If authenticated, response will be user object
            // If not authenticated, response will be 'false'
            // Set subjects appropriately
            if (response) {
                var user = response;
                _this.userProfileSubject$.next(user);
            }
            _this.loggedIn = !!response;
            // Clean up subscription
            checkAuthSub.unsubscribe();
        });
    };
    AuthService.prototype.login = function (redirectPath) {
        if (redirectPath === void 0) { redirectPath = '/'; }
        // A desired redirect path can be passed to login method
        // (e.g., from a route guard)
        // Ensure Auth0 client instance exists
        this.auth0Client$.subscribe(function (client) {
            // Call method to log in
            client.loginWithRedirect({
                redirect_uri: window.location.origin + "/callback",
                appState: { target: redirectPath }
            });
        });
    };
    AuthService.prototype.handleAuthCallback = function () {
        var _this = this;
        // Only the callback component should call this method
        // Call when app reloads after user logs in with Auth0
        var targetRoute; // Path to redirect to after login processsed
        // Ensure Auth0 client instance exists
        var authComplete$ = this.auth0Client$.pipe(
        // Have client, now call method to handle auth callback redirect
        Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function () { return _this.handleRedirectCallback$; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["tap"])(function (cbRes) {
            // Get and set target redirect route from callback results
            targetRoute = cbRes.appState && cbRes.appState.target ? cbRes.appState.target : '/';
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["concatMap"])(function () {
            // Redirect callback complete; create stream
            // returning user data and authentication status
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["combineLatest"])(_this.getUser$(), _this.isAuthenticated$);
        }));
        // Subscribe to authentication completion observable
        // Response will be an array of user and login status
        authComplete$.subscribe(function (_a) {
            var _b = tslib__WEBPACK_IMPORTED_MODULE_0__["__read"](_a, 2), user = _b[0], loggedIn = _b[1];
            // Update subjects and loggedIn property
            _this.userProfileSubject$.next(user);
            _this.loggedIn = loggedIn;
            // Redirect to target route after callback processing
            _this.router.navigate([targetRoute]);
        });
    };
    AuthService.prototype.logout = function () {
        // Ensure Auth0 client instance exists
        this.auth0Client$.subscribe(function (client) {
            // Call method to log out
            client.logout({
                client_id: "nnYSyk0KQICzZwfZRPPJNWmI47asiwws",
                returnTo: "" + window.location.origin
            });
        });
    };
    AuthService.ctorParameters = function () { return [
        { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }
    ]; };
    AuthService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/services/kardex.service.ts":
/*!********************************************!*\
  !*** ./src/app/services/kardex.service.ts ***!
  \********************************************/
/*! exports provided: KardexService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "KardexService", function() { return KardexService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");



var KardexService = /** @class */ (function () {
    function KardexService(http) {
        this.http = http;
        this.token = '';
    }
    KardexService.prototype.getQuery = function (query) {
        var url = "/api/v1" + query;
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ Authorization: "'Bearer " + this.token + "'" });
        return this.http.get(url, { headers: headers });
    };
    KardexService.prototype.getPost = function (query, data) {
        var url = "api/v1" + query;
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ Authorization: "'Bearer " + this.token + "'" });
        return this.http.post(url, data, { headers: headers });
    };
    KardexService.prototype.getInventario = function () {
        return this.getQuery('/inventario/');
    };
    KardexService.prototype.getProducto = function (codproducto) {
        return this.getQuery("/productos/" + codproducto);
    };
    KardexService.prototype.comprarProductos = function (compra) {
        return this.getPost('/operaciones/producto/compra', compra);
    };
    KardexService.prototype.venderProductos = function (venta) {
        return this.getPost('/operaciones/producto/venta', venta);
    };
    KardexService.prototype.getKardex = function (codproducto) {
        return this.getQuery("/kardex/" + codproducto);
    };
    KardexService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
    ]; };
    KardexService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], KardexService);
    return KardexService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! G:\Trabajo\remoto\ws.todo1\hulkstore\angularUI\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es5.js.map