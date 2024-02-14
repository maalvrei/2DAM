from odoo import models, fields

class Comentario(models.Model):
    _name= 'proyectosplus.comentario'
    _description = 'Comentario'
    author_id = fields.Many2one(comodel_name='res.users', string='Autor')
    comment = fields.Text(string='Comentario')
    timestap = fields.Datetime(string='Fecha y hora')