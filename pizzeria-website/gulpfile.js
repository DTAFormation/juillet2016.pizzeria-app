var gulp = require("gulp");
var plugins = require('gulp-load-plugins')();
var paths = require('./gulp.config.json');
var del = require("del");
var browserify = require("browserify");
var source = require("vinyl-source-stream");
var watchify = require("watchify");

var colors = plugins.util.colors;
var log = plugins.util.log;

/*
 * Create a server
 */
gulp.task("connect", function () {
    plugins.connect.server({
        /** Default path */
        root: "public",
        port: 10080
    });
});

var server = plugins.jsonSrv.create();
/*
 * Load mock data pizzeria
 */
gulp.task('datas', function () {
    log("load mocks data");
    return gulp.src("datas/pizzeria.json")
        .pipe(server.pipe());
});

/*
 * Views angular and static html files
 */
gulp.task("html", function () {
    log("build html");
    return gulp
        .src(paths.html)
        .pipe(gulp.dest('public'));
});

/** Librairies css */
gulp.task("libs-css", function () {
    log("Build css librairies");
    return gulp
        .src(paths.libsCss)
        .pipe(gulp.dest(paths.public + '/assets/css/bootstrap/'));
});

var opts = {
    entries: [paths.browserifyPath],
    debug: true
};
var b = watchify(browserify(opts));

gulp.task('browserify', bundle);
b.on('update', bundle);

function bundle() {
    return b.bundle()
        .on('error', log.bind(plugins.util, 'Browserify Error'))
        .pipe(source('bundle.js'))
        .pipe(gulp.dest(paths.public + 'js/'));
}


/** remove all files public folder */
gulp.task('clean', function () {
    log('Cleaning: ' + colors.blue(paths.public));

    var delPaths = [].concat(paths.public);
    del.sync(delPaths);
});

/** move img */
gulp.task("img", function () {
    log("move img");
    return gulp
        .src(paths.img)
        .pipe(gulp.dest(paths.public + '/img/'));
});
/** move translate */
gulp.task("translate", function () {
    log("move translate");
    return gulp
        .src(paths.translate)
        .pipe(gulp.dest(paths.public + '/translate/'));
});

/*
 * Build application task
 */
gulp.task('build', ['connect', 'datas', 'libs-css', 'browserify', 'html','img','translate']);

gulp.task("default", ["clean"], function () {
    gulp.start("build");
});

/*
 * Watch Task
 */
gulp.task("watch", function () {
    gulp.start('datas');
    gulp.start('connect');
    gulp.start('browserify');
    gulp.start('img');
    gulp.start('translate');

    gulp.watch(paths.html, ["html"]);
    gulp.watch(["datas/pizzeria.json"], ["datas"], function () {
        console.log(server);
    });
});
